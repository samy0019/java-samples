package com.packtpub.chapter4.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.packtpub.chapter4.entity.Property;

@Singleton
@Remote(SingletonBeanRemote.class) 
public class  SingletonBeanRemoteImpl implements SingletonBeanRemote  {
  
 private  List<Property> cache; 
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager em;

 @PostConstruct
 public void initCache(){
   this.cache = queryCache();
   if (cache == null) cache = new ArrayList<Property>();
 }

 public void delete(){
	 Query query = em.createQuery("delete FROM com.packtpub.chapter4.entity.Property");
	  query.executeUpdate();
	  this.cache.clear();
 }
 public void put(String key,String value){
	 Property p = new Property();
	  p.setKey(key);
	  p.setValue(value);
	  em.persist(p);
	  
      this.cache.add(p);
 }
 public List<Property> getCache() {
	 return cache;
 }
 public List<Property>  queryCache(){
		Query query = em.createQuery("FROM com.packtpub.chapter4.entity.Property");
 
		List <Property> list =  query.getResultList();
		return list;	      
}
	      


}
