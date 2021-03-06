package com.toughguy.sinograin.service.barn.prototype;

import java.util.List;

import com.toughguy.sinograin.model.barn.Library;
import com.toughguy.sinograin.model.barn.Manuscript;
import com.toughguy.sinograin.service.prototype.IGenericService;

public interface ILibraryService extends IGenericService<Library, Integer> {
	
	public List<Library> findFirst();
}
