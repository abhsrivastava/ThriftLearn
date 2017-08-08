namespace * com.abhi.temprature.thrift

struct TempratureDatum {
    1: i32 celcius,
    2: i64 timestamp
}

service TempratureService {
    void add(1: TempratureDatum datum);
    double mean();
}