package com.example.demo.ifs;

import com.example.demo.network.Header;
import com.example.demo.network.request.UserApiRequest;

public interface CrudInterface<Req,Res> {
	
	Header<Res> create(Req request);
	
	Header<Res> read(Long id);
	
	Header<Res> update(Req request);
	
	Header delete(Long id);
}
