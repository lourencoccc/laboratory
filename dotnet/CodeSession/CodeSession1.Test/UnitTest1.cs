using System;
using Xunit;

namespace CodeSession1Test
{
    public class UnitTest1
    {
        [Fact]
        public void Test1()
        {
            Assert.Equal(2, Add(1, 1));
        }

        [Theory]
        [InlineData(2)]
        [InlineData(4)]
        // [InlineData(3)]
        public void testTheory(int value)
        {
            Assert.True(isEven(value));
        }

        public int Add(int a, int b)
        {
            return a + b;
        }

        public bool isEven(int a)
        {
            return a % 2 == 0;
        }
    }
}