
package com.barclay.application.theaterseating.service;

import com.barclay.application.theaterseating.model.RequestInput;

public interface TheatreService 
{
				int capacity(RequestInput requestInput);
				void allowSeating(RequestInput requestInput,int capacity);
}