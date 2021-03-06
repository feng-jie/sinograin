package com.toughguy.sinograin.persist.barn.impl;

import org.springframework.stereotype.Repository;

import com.toughguy.sinograin.model.barn.SmallSample;
import com.toughguy.sinograin.persist.barn.prototype.ISmallSampleDao;
import com.toughguy.sinograin.persist.impl.GenericDaoImpl;

@Repository
public class SmallSampleDaoImpl extends GenericDaoImpl<SmallSample, Integer> implements ISmallSampleDao {

}
