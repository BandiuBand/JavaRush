package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker{
    public void print(int i)
    {
        System.out.println("nothing  " + i);
    }
    public void print()
    {
        System.out.println("nothing");
    }
}
