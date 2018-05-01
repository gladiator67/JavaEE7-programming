package com.aaa.ejb3;

import java.util.List;
import javax.ejb.Local;

@Local
public interface ICartPort {

    public void initialize(String personId) throws Exception;
    public void addBook(String title);
    public void removeBook(String title) throws Exception;
    public List<String> getContents();
    public void remove();
}
