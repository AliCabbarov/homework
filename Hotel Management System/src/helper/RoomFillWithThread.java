package helper;

import data.GlobalData;
import model.Room;
import util.RandomUtil;

public class RoomFillWithThread implements Runnable{
    private static int roomId;
    @Override
    public void run() {
        registerRoom();
    }
    private void registerRoom(){
        for (int i = 1; i <= 100; i++) {
            if(i < 25){
                Room room = new Room(++roomId,i,"single",false, RandomUtil.getInstance().inputRandom());
                GlobalData.rooms.add(room);
            }else if(i < 50){
                Room room = new Room(++roomId,i,"standard",false, RandomUtil.getInstance().inputRandom());
                GlobalData.rooms.add(room);
            }else if(i < 75){
                Room room = new Room(++roomId,i,"duplex",false, RandomUtil.getInstance().inputRandom());
                GlobalData.rooms.add(room);
            }else {
                Room room = new Room(++roomId,i,"suite",false, RandomUtil.getInstance().inputRandom());
                GlobalData.rooms.add(room);
            }
        }
    }
}
