package com.example.demo.ifs;

import com.example.demo.network.Header;

public interface CrudInterface {
	
	Header create();
	
	Header read(Long id);
	
	Header update();
	
	Header delete(Long id);
}
