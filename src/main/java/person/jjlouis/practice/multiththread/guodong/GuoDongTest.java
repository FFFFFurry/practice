package person.jjlouis.practice.multiththread.guodong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 作者：jjlouis
 * 时间：2018/5/24 13:38
 * 联系方式：
 * 功能：
 **/
public class GuoDongTest {

    public Set<String> buildPointSet(int x,int y){
        Set<String> points = new HashSet<>();
        for(int i = 0; i<= x ; i++){
            for(int j =0 ; j<= y ;j++){
                points.add(i + "," + j);
            }
        }
        return points;
    }

    public void removePoints(Set<String> points,int maxX,int maxY,int count){

        int minX = count;
        maxX -= count;

        int minY = count;
        maxY -= count;

        if(points.size() == 1) return;

        for(int y = minY;y<= maxY;y++){
            if(removePoint(points,minX,y)) return;
        }
        for(int x = minX;x<= maxX;x++){
            if (removePoint(points,x,maxY)) return;
        }
        for(int y = maxY;y >= minY;y--){
            if(removePoint(points,maxX,y)) return;
        }
        for(int x = maxX;x >  minX ;x--){
            if(removePoint(points,x,minY)) return;
        }
        removePoints(points,maxX,maxY,++count);
    }

    private boolean removePoint(Set<String> points,int x,int y){
        if(points.size() == 1){
            return true;
        }else{
            points.remove(x + "," + y);
            return false;
        }

    }

    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        GuoDongTest test = new GuoDongTest();
        Set<String> points = test.buildPointSet(x,y);
        test.removePoints(points,x,y,0);
        System.out.println(new ArrayList<>(points).get(0));
        System.out.println(points.size());
    }

}
