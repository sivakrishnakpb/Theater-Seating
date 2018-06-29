
package com.barclay.application.theaterseating.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.barclay.application.theaterseating.model.RequestInput;
import com.barclay.application.theaterseating.model.TicketRequest;
import com.barclay.application.theaterseating.service.TheatreService;
import com.barclay.application.theaterseating.service.impl.TheatreServiceImpl;

import junit.framework.Assert;

public class TheaterServiceImplTest {

    private TheatreService theaterService;
    private RequestInput requestInput;

    @org.junit.Before
    public void setUp() throws Exception {
        requestInput =new RequestInput();
        List<TicketRequest> request=new ArrayList<TicketRequest>();
        TicketRequest request1=new TicketRequest("TestName",5);
        TicketRequest request2=new TicketRequest("TestName",100);
        TicketRequest request3=new TicketRequest("TestName",2);
        request.add(request1);
        request.add(request2);
        request.add(request3);
        requestInput .setRequest(request);
        List<Integer> layOutRow= Arrays.asList(5,4);
        List<Integer> layOutRow1=Arrays.asList(6,8,8);
        List<List<Integer>> layOut=Arrays.asList(layOutRow,layOutRow1);
        requestInput.setLayout(layOut);
    }

    @org.junit.Test
    public void totalCapacity() {
        theaterService=new TheatreServiceImpl();
        int totalCapacity=theaterService.capacity(requestInput);
        Assert.assertNotNull(totalCapacity);
        Assert.assertEquals(totalCapacity,31);
    }

    @org.junit.Test
    public void allowSeating() {
        theaterService=new TheatreServiceImpl();
        theaterService.allowSeating(requestInput,31);
    }
}