require 'minitest/autorun'
require './hw3.rb'

class Hw3Test < Minitest::Test

  def setup
    @test = Hw3.new
  end

  def test_greatest5
    assert_equal 5, @test.greatest5(3,5,4,3,5)
    assert_equal 5, @test.greatest5(1,2,5,4,3)
  end

  def test_sum45
    assert_equal 17, @test.sum45(3,5,4,3,5)
    assert_equal 14, @test.sum45(1,2,5,4,3)
  end

  def test_anyDivide3
    assert_equal false, @test.anyDivide3(2,5,3)
    assert_equal true, @test.anyDivide3(10,5,4)
    assert_equal true, @test.anyDivide3(10,2,10)
  end

  def test_sumEven4
    assert_equal 2, @test.sumEven4(5,3,7,2)
    assert_equal 8, @test.sumEven4(5,6,2,5)
    assert_equal 16, @test.sumEven4(10,4,5,2)
    assert_equal 0, @test.sumEven4(5,3,7,1)
  end

  def test_sumEvenProdOdd4
    assert_equal 107, @test.sumEvenProdOdd4(5,3,7,2)
    assert_equal 21, @test.sumEvenProdOdd4(10,4,5,2)
    assert_equal 33, @test.sumEvenProdOdd4(5,6,2,5)
    assert_equal 105, @test.sumEvenProdOdd4(5,3,7,1)
    assert_equal 21, @test.sumEvenProdOdd4(2,4,6,8)
  end

end
