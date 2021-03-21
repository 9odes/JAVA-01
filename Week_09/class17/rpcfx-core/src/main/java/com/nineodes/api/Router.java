package com.nineodes.api;

import java.util.List;

public interface Router {

    List<String> route(List<String> urls, Class serviceClass);
}
