//package com.javarush.task.task20.task2028;
//
//import java.io.Serializable;
//import java.util.AbstractList;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///*
//Построй дерево(1)
//*/
//
//public class CustomTree extends AbstractList<String> implements Cloneable, Serializable{
//    private List<Entry<String>> entryes = new ArrayList<>();
//    Entry<String> root;
//    public CustomTree()
//    {root = new Entry<>("root");
//    entryes.add(root);}
//    @Override
//    public boolean addAll(int index, Collection<? extends String> c) {
//        throw new UnsupportedOperationException();
//    }
//    @Override
//    public boolean add (String name)
//    {
//        for (Entry<String> entry: entryes) {
//            if (entry.availableToAddLeftChildren)
//            {
//                Entry<String> curentNew = new Entry<>(name, entry);
//                entryes.add(curentNew);
//                entry.setLeftChild(curentNew);
//                entry.setAvailableToAddLeftChildren(false);
//                return true;
//            }
//            else if (entry.availableToAddRightChildren)
//            {
//                Entry<String> curentNew = new Entry<>(name, entry);
//                entryes.add(curentNew);
//                entry.setRightChild(curentNew);
//                entry.setAvailableToAddRightChildren(false);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean remove (Object element)
//    {   try {
//        if (!(element instanceof String) || (element == null))
//            throw new UnsupportedOperationException();
//        for (Entry<String> entry : entryes) {
//            if (entry.getElementName().equals(element)) {
//                Entry<String> parentCurent = entry.getParent();
//                if (parentCurent.getLeftChild() == entry) {
//                    parentCurent.setLeftChild(null);
//                    parentCurent.setAvailableToAddLeftChildren(true);//uuuuuuuuuuuuuuuuuuuu
//                } else {
//                    parentCurent.setRightChild(null);
//                    parentCurent.setAvailableToAddRightChildren(true);//uuuuuuuuuuuuuuuuuuuu
//                }
//                removeChildren(entry);
//                myRemove(entryes,entry);
//            }
//        }
//    }
//
//    catch (Exception e)
//    {
//        throw new UnsupportedOperationException();
//    }
//    return true;}
//
//    private void myRemove (List<Entry<String>> list,Entry<String> entry)
//    {
//        List<Entry<String>> newList= new ArrayList<>();
//        for (Entry<String> entryF:entryes) {
//            if (!(entryF.getElementName().equals(entry.elementName)))
//                newList.add(entryF);
//        }
//        entryes=newList;
//    }
//
//
//
//    private void removeChildren(Entry<String> name)
//    {
//        if (name.getLeftChild()!=null) {
//            removeChildren(name.getLeftChild());
//            myRemove(entryes,name.getLeftChild());
//        }
//        if (name.getRightChild()!=null)
//        {
//            removeChildren(name.getRightChild());
//            myRemove(entryes,name.getRightChild());
//        }
//    }
//    public String getParent(String name)
//    {
//        for (Entry<String> entry:entryes){
//            if (entry.getElementName().equals(name))
//                return entry.getParentName();
//
//    }
//        return "null";
//
//    }
//    @Override
//    public int size()
//    {
//        int size = entryes.size();
//        return size - 1;
//    }
//
//    @Override
//    protected void removeRange(int fromIndex, int toIndex) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public List<String> subList(int fromIndex, int toIndex) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public String remove(int index) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public void add(int index, String element) {
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//
//    @Override
//    public String get(int index) {
//        throw new UnsupportedOperationException();
////        System.out.println("pizda");
////        return "";
//    }
//    @Override
//    public String set(int index,String element) {
//        throw new UnsupportedOperationException();
//    }
//
//
//    static class Entry<T> implements Serializable
//    {
//        String elementName;
//        boolean availableToAddLeftChildren;
//        boolean availableToAddRightChildren;
//        Entry<T> parent,leftChild,rightChild;
//
//        public void setLeftChild(Entry<T> leftChild) {
//            this.leftChild = leftChild;
//        }
//
//        public void setRightChild(Entry<T> rightChild) {
//            this.rightChild = rightChild;
//        }
//
//        public Entry<T> getLeftChild() {
//            return leftChild;
//        }
//
//        public Entry<T> getRightChild() {
//            return rightChild;
//        }
//
//        public void setParent(Entry<T> parent) {
//            this.parent = parent;
//        }
//
//        public Entry(String elementName,Entry<T> parent)
//        {
//            this.elementName = elementName;
//            this.availableToAddLeftChildren = true;
//            this.availableToAddRightChildren = true;
//            this.parent = parent;
//        }
//        public Entry(String elementName) {
//            this.elementName = elementName;
//            this.availableToAddLeftChildren = true;
//            this.availableToAddRightChildren = true;
//        }
//        public boolean isAvailableToAddChildren()
//        {
//            return availableToAddLeftChildren||availableToAddRightChildren;
//        }
//
//        public void setAvailableToAddLeftChildren(boolean availableToAddLeftChildren) {
//            this.availableToAddLeftChildren = availableToAddLeftChildren;
//        }
//
//        public void setAvailableToAddRightChildren(boolean availableToAddRightChildren) {
//            this.availableToAddRightChildren = availableToAddRightChildren;
//        }
//
//        public String getElementName() {
//            return elementName;
//        }
//
//        public String getParentName() {
//            return parent.elementName;
//        }
//
//        public Entry<T> getParent() {
//            return parent;
//        }
//    }
//}
