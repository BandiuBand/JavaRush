package com.javarush.task.task24.task2409;

public interface Item {
    int getId();
    double getPrice();
    String getTM();

}
/*
1. ������ 2 ���������� � ��������� ������:
        1.1) Item � �������� int getId(), double getPrice(), String getTM()
        1.2) Jeans extends Item � �������� int getLength() � int getSize()

        2. � ������ Util � ������ getAllJeans ������ ����������� ����� java-����:
        2.1) ��������� � ���, ��� ��� ���� � ������ getAllJeans ������ Util
        2.2) ������ ����������� class AbstractJeans �� ���������� Jeans � ����� ����������� �������, �������� ��������� ������
2.3) ������ ������ Levis � Denim �� AbstractJeans, �������� ���������� �����
        2.4) � ������ AbstractJeans �������� ����� toString() (������ ��������������� Alt+Insert -> toString())
        2.5) ����� toString ������ AbstractJeans ������ ���������� � ����� ���������, ��������, Levis{id=1, length=34, size=6, price=150.0}

*/
