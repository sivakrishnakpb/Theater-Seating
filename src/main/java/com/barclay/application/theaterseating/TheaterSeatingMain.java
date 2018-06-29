package com.barclay.application.theaterseating;

import com.barclay.application.theaterseating.model.RequestInput;
import com.barclay.application.theaterseating.service.TheatreService;
import com.barclay.application.theaterseating.service.impl.TheatreServiceImpl;
import com.barclay.application.theaterseating.util.TheatreUtil;


public class TheaterSeatingMain {
    public static void main(String args[]) 
    {
        TheatreUtil theatreUtil=new TheatreUtil();
        TheatreService service= new TheatreServiceImpl();
        RequestInput layout = theatreUtil.getLayout();
        int capacity =service.capacity(layout);
        service.allowSeating(layout, capacity);
          }
}