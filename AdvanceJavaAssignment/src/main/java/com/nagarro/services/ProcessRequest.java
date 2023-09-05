package com.nagarro.services;

import java.util.List;

import com.nagarro.entity.Tshirts;

public interface ProcessRequest {


	List<Tshirts> processReq(Tshirts t, List<Tshirts> list);

}
