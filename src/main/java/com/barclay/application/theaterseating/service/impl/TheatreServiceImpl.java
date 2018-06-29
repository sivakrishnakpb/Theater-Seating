
package com.barclay.application.theaterseating.service.impl;

import java.util.Collection;
import java.util.List;

import com.barclay.application.theaterseating.model.RequestInput;
import com.barclay.application.theaterseating.model.TicketRequest;
import com.barclay.application.theaterseating.service.TheatreService;

public class TheatreServiceImpl implements TheatreService 
{
  public int capacity(RequestInput requestInput) {
		// TODO Auto-generated method stub
		List<List<Integer>> layout = requestInput.getLayout();
		int sum =layout.stream().flatMap(Collection::stream).mapToInt(i -> i).sum();
		return sum;
	}
  public void allowSeating(RequestInput requestInput, int capacity) {
      List<List<Integer>> layOut =requestInput.getLayout();
      List<TicketRequest> request = requestInput.getRequest();
      for(TicketRequest ticketRequest : request)
      {
          if (ticketRequest.getNoOfTicketsReq() > capacity) {
              System.out.println(ticketRequest.getName() + " Sorry, we cannot handle your party");

          } else {
              int rowTemp = 0;
              int section = 0;
              boolean match = false;
              for (List<Integer> row : layOut) {
                  section = 0;
                  for (Integer sectionValue : row) {
                      if ((sectionValue - ticketRequest.getNoOfTicketsReq()) > 1 || (sectionValue - ticketRequest.getNoOfTicketsReq()) == 0  ) {
                          layOut.get(rowTemp).set(section,
                                  (layOut.get(rowTemp).get(section)) - ticketRequest.getNoOfTicketsReq());
                          System.out.println(ticketRequest.getName() + " Row " + (rowTemp + 1) + " Section " + (section + 1));
                          capacity -= ticketRequest.getNoOfTicketsReq();
                          match = true;
                          break;
                      }
                      section++;
                  }
                  if (match)
                      break;
                  rowTemp++;
              }
              if (!match) {
                  System.out.println(ticketRequest.getName() + " Call to split party.");
              }
          }
      }
  }
}