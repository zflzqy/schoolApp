package school.util;

public class Page {
    private int start; // 开始位置

    private int count =10; // 每页个数，默认为 5

    private int last ; // 最后一页

    // 计算最后一页的位置==>根据总数
    public  void  getLastLocation(int total){
        // 如果能够被每页的数量整除，n那么最后一页的起始位置为总数减去每页的数量
        if (0==total%count){
            last = total-count;
        }
        // 如果不能被整除，那么最后一页的起始位置为总数减去总数与每页数量取余部分，也就是不能整除那部分
        if (0!=total%count){
            last = total -total%count;
        }
    }
    public int getStart() {
        if (start>=0)
            this.start = start;
        else
            start =0;
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", count=" + count +
                ", last=" + last +
                '}';
    }
}
