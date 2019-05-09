package main.server.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Collection;
import java.util.List;

public abstract class AbstractRepository<DATA> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<DATA> data;

    protected AbstractRepository(Class<DATA> data){
        this.data = data;
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public DATA getItem(Long id){
        Session session = sessionFactory.getCurrentSession();
        DATA o = session.get(data,id);
        return o;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public Collection<DATA> getAllItems(){
        Session session = sessionFactory.getCurrentSession();
        List<DATA> o = (List<DATA>) session.createCriteria(data).list();
        return o;
    }

    @Transactional
    public DATA createItem(DATA data){
        Session session = sessionFactory.getCurrentSession();
        session.persist(data);
        return data;
    }

    @Transactional
    public DATA modifyItem(DATA data){
        Session session = sessionFactory.getCurrentSession();
        session.update(data);
        return data;
    }

    //TODO Becouse @GeneratedValue is not supported
    private static Long id = null;
    private static File file = null;
    public static Long getId(){
        id += 1;
        try {
            PrintWriter  writer = new PrintWriter(file);
            writer.write(String.valueOf(id));
            writer.close();
        }catch (Exception e){ e.printStackTrace(); }
        return id;
    }
    @Autowired
    private ApplicationContext applicationContext;
    @PostConstruct
    private void init(){
        if(id == null) {
            try {
                file = new File(applicationContext.getResource("classpath:sequence").getFile().getAbsolutePath());
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                id =  Long.parseLong(br.readLine());
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
