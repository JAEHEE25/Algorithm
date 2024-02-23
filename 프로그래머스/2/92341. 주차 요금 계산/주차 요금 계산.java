import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> cars = new HashMap<>();
        
        for (String record : records) {
            String[] rec = record.split(" ");
            String time = rec[0];
            String number = rec[1];
            String history = rec[2];
             
            if (history.equals("IN")) {
                if (cars.keySet().contains(number)) { //들어왔던 차라면
                    Car inCar = cars.get(number);
                    inCar.inTime = calculateTime(time);
                    inCar.isOut = false;
                } else { //새로 들어온 차라면
                    cars.put(number, new Car(calculateTime(time), 0, false, 0, 0)); 
                }
            } else { //OUT
                Car outCar = cars.get(number);
                outCar.outTime = calculateTime(time);
                outCar.parkTime += (outCar.outTime - outCar.inTime);
                outCar.isOut = true;
            }        
        }
        
        //23:59 계산
        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            Car car = entry.getValue();
            if (!car.isOut) {
                car.outTime = calculateTime("23:59");
                car.parkTime += (car.outTime - car.inTime);
            }
        }
        
        //요금 계산
        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            Car car = entry.getValue();
            if (car.parkTime > fees[0]) { //초과 시간
                int exceed = (int) Math.ceil((double) (car.parkTime - fees[0]) / (double) fees[2]);
                int fee = fees[1] + exceed * fees[3];
                car.totalFee += fee;
            } else { //기본 시간
                car.totalFee += fees[1];
            }
            
        }
        
        List<String> keyList = new ArrayList<>(cars.keySet());
        Collections.sort(keyList);
        int[] answer = new int[keyList.size()];
        for (int i = 0; i < keyList.size(); i++) {
            answer[i] = cars.get(keyList.get(i)).totalFee;
        }
        return answer;
    }
    
    public int calculateTime(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]) * 60;
        int m = Integer.parseInt(t[1]);
        return h + m;
    } 
}

class Car {
    int inTime;
    int outTime;
    boolean isOut;
    int parkTime;
    int totalFee;
    
    Car(int inTime, int outTime, boolean isOut, int parkTime, int totalFee) {
        this.inTime = inTime;
        this.outTime = outTime;
        this.isOut = isOut;
        this.parkTime = parkTime;
        this.totalFee = totalFee;
    }
}