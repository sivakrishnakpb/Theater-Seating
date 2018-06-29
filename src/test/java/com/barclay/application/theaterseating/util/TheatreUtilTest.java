package com.barclay.application.theaterseating.util;

import org.junit.Test;

import com.barclay.application.theaterseating.util.TheatreUtil;

public class TheatreUtilTest {

    private TheatreUtil theatreUtil;

    @Test
    public void getLayout() {
        theatreUtil=new TheatreUtil();
        theatreUtil.getLayout();
    }
}