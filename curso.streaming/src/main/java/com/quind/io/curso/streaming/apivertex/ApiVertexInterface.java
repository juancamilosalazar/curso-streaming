package com.quind.io.curso.streaming.apivertex;

import com.quind.io.curso.streaming.model.EventCustomer;

import java.io.IOException;
import java.util.List;

public interface ApiVertexInterface {
    public List<String> consumeModelIa(EventCustomer eventCustomer) throws IOException;
}
