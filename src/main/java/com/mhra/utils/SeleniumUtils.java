package com.mhra.utils;

import java.util.logging.Logger;

;
public class SeleniumUtils{
    private static Logger logger = Logger.getLogger(SeleniumUtils.class.getName());

    public static void addWaitForCurrentThread(int milliseconds){
        try {
            Thread.sleep(milliseconds); 
        } catch (Exception e) {
            logger.info("Exception occured while making current thread wait...");
    
        }
        
    }
}