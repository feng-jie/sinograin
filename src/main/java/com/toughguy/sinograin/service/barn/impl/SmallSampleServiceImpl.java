package com.toughguy.sinograin.service.barn.impl;

import org.springframework.stereotype.Service;

import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.service.barn.prototype.ISmallSampleService;
import com.toughguy.sinograin.service.impl.GenericServiceImpl;

@Service
public class SmallSampleServiceImpl extends GenericServiceImpl<SmallSample, Integer> implements ISmallSampleService{

}
