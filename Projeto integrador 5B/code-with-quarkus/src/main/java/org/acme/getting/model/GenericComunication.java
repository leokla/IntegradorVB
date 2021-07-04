package org.acme.getting.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GenericComunication {

    protected Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
}
