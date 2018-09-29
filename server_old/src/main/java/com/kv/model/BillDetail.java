package com.kv.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class BillDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Product product;

    private int quantity;
}
