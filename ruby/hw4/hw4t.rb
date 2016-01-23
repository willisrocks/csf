require 'minitest/autorun'
require 'minitest/reporters'
require './hw4.rb'

class Hw4Test < Minitest::Test
  reporter_options = { color: true }
  Minitest::Reporters.use! [Minitest::Reporters::DefaultReporter.new(reporter_options)]


  def setup
    @test = Hw4.new
  end

  def test_sumTo
    assert_equal 1, @test.sumTo(1)
    assert_equal 10, @test.sumTo(4)
    assert_equal 0, @test.sumTo(0)
    assert_equal 55, @test.sumTo(10)
  end

  def test_sumOfSums
    assert_equal 1, @test.sumOfSums(1)
    assert_equal 20, @test.sumOfSums(4)
    assert_equal 0, @test.sumOfSums(0)
  end

  def test_sumOfEvenBetween
    assert_equal 6, @test.sumOfEvenBetween(2,5)
    assert_equal 6, @test.sumOfEvenBetween(5,2)
    assert_equal 30, @test.sumOfEvenBetween(1,10)
    assert_equal 0, @test.sumOfEvenBetween(5,5)
  end

  def test_sumPropDivisors
    assert_equal 0, @test.sumPropDivisors(0)
    assert_equal 0, @test.sumPropDivisors(1)
    assert_equal 6, @test.sumPropDivisors(6)
    assert_equal 8, @test.sumPropDivisors(10)
    assert_equal 1, @test.sumPropDivisors(13)
  end

  def test_isPerfect
    assert_equal false, @test.isPerfect(1)
    assert_equal false, @test.isPerfect(4)
    assert_equal true, @test.isPerfect(6)
    assert_equal false, @test.isPerfect(10)
    assert_equal true, @test.isPerfect(28)
    assert_equal true, @test.isPerfect(496)
  end

  def test_isPrime
    assert_equal false, @test.isPrime(1)
    assert_equal true, @test.isPrime(2)
    assert_equal true, @test.isPrime(5)
    assert_equal false, @test.isPrime(9)
    assert_equal false, @test.isPrime(93)
    assert_equal true, @test.isPrime(101)
  end

end
