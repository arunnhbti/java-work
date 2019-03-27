class MyMutableInteger
{
    int value;

    public MyMutableInteger(int val)
    {
        this.value = val;
    }

    int getValue()
    {
        return this.value;
    }

    void setValue(int val)
    {
        this.value = val;
    }
}