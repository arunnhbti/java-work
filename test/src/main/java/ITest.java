public interface ITest
{
    default String test(String test)
    {
        throw new UnsupportedOperationException("This feature is not supported for entity : " + getClass().getTypeName());
    }
}
