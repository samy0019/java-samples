package com.packtpub.chapter4.ejb;

import java.util.List;
import com.packtpub.chapter4.entity.Property;

public interface SingletonBeanRemote {
	 public void delete();
	 public void put(String key,String value);
	 public List<Property> getCache();
	 public List<Property>  queryCache();
}
