package com.cn.nicole.AstackAndQueue;
/*
 * author: Nicole
 * email : nicolechen412@163.com
 * date  : 2021/4/25 12:52 下午
 * desc  :
 */

import com.cn.nicole.entity.Pet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 04.实现猫狗队列，实现add pollAll pollDog pollCat isEmpty isDogEmpty isCatEmpty方法
 *
 * 实现思路：
 *  1.封装一个实体类，类中有两个队列分别存储cat和dog，使用公共计数器。
 */
public class CatAndDog {

    private final static String dog = new String("Dog");
    private final static String cat = new String("Cat");


    public static void main(String[] args) {
        DogCatQueue dogCatQueue = new DogCatQueue();
        Pet pet1 = new Pet(cat);
        Pet pet2 = new Pet(dog);
        Pet pet3 = new Pet(cat);
        Pet pet4 = new Pet(cat);

        dogCatQueue.add(pet1);
        dogCatQueue.add(pet2);
        dogCatQueue.add(pet3);
        dogCatQueue.add(pet4);

        System.out.println(dogCatQueue.pollAll().getType());
        System.out.println(dogCatQueue.pollCat().getType());
        System.out.println(dogCatQueue.pollDog().getType());
        System.out.println(dogCatQueue.isDogEmpty());
        System.out.println(dogCatQueue.isEmpty());

        System.out.println(dogCatQueue.pollCat().getType());
        System.out.println(dogCatQueue.isCatEmpty());
        System.out.println(dogCatQueue.isEmpty());




    }

}

class PetEntity {
    private Pet pet;
    private int count;

    public PetEntity(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return pet.getType();
    }
}

class DogCatQueue {

    private Queue<PetEntity> dogQueue;
    private Queue<PetEntity> catQueue;
    int count;

    public DogCatQueue() {
        this.dogQueue = new LinkedList<PetEntity>();
        this.catQueue = new LinkedList<PetEntity>();
        count = 0;
    }

    public void add(Pet pet) {

        if (pet.getType().equals("Cat")) {
            catQueue.add(new PetEntity(pet, count++));
        } else if (pet.getType().equals("Dog")) {
            dogQueue.add(new PetEntity(pet, count++));
        } else {
            throw new RuntimeException("not car or dog type");
        }
    }

    public Pet pollAll() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            throw new RuntimeException("queue is null");
        } else if (dogQueue.isEmpty()) {
            return catQueue.poll().getPet();
        } else if (catQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        } else {
            if (dogQueue.peek().getCount() < catQueue.peek().getCount()) {
                return dogQueue.poll().getPet();
            }else if (catQueue.peek().getCount() < dogQueue.peek().getCount()) {
                return catQueue.poll().getPet();
            } else {
                throw new RuntimeException("count equal");
            }
        }
    }

    public Pet pollDog() {

        if (dogQueue.isEmpty()) {
            throw new RuntimeException("queue is null");
        } else {
            return dogQueue.poll().getPet();
        }
    }

    public Pet pollCat() {

        if (catQueue.isEmpty()) {
            throw new RuntimeException("queue is null");
        } else {
            return catQueue.poll().getPet();
        }
    }

    public Boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public Boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public Boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

}
