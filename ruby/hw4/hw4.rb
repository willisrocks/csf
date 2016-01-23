class Hw4

  ######################################
  # sumTo() takes an integer
  # and returns the sum of all integers
  # between 1 and the number given

  def sumTo(n)
    sum = 0

    for i in 1..n do
      sum += i
    end

    return sum
  end

  ######################################
  # sumOfSums() takes an integer
  # and returns an integer with the
  # sum of all the sumTo() calls of
  # integers between 1 and the number
  # given

  def sumOfSums(n)
    sum = 0

    for i in 1..n do
      sum += sumTo(i)
    end

    return sum
  end

  ######################################
  # sumOfEvenBetween() takes 2 integers
  # and returns an integer with the
  # sum of all the integers between the
  # first number and the second that
  # are even. Either number can be the
  # largest

  def sumOfEvenBetween(a, b)
    sum = 0

    for i in min(a,b)..max(a,b) do
      if (i % 2 == 0)
        sum += i
      end
    end

    return sum
  end

  ######################################
  # sumPropDivisors() takes an integer
  # and returns an integer that is the
  # sum of all the proper divisors

  def sumPropDivisors(n)
    sum = 0

    for i in 1..n-1 do
      if(n % i == 0)
        sum += i
      end
    end

    return sum
  end

  ######################################
  # isPerfect() takes an integer
  # greater than 0 and returns a boolean
  # true if the number equals the sum
  # of its proper divisors (perfect
  # number)

  def isPerfect(n)
    if (n > 0 and sumPropDivisors(n) == n)
      return true
    end

    return false
  end

  ######################################
  # isPrime() takes an integer and
  # returns a boolean true if the number
  # is prime

  def isPrime(n)
    if (n <= 1)
      return false
    elsif (n <= 3)
      return true
    elsif (n % 2 == 0 or n % 3 == 0)
      return false
    end

    for i in 2..Math.sqrt(n) do
      if (n % i == 0)
        return false
      end
    end

    return true
  end


  ######################################
  # Helper Functions
  ######################################

  def max(a, b)
    (a > b) ? a : b
  end

  def min(a, b)
    (a < b) ? a : b
  end

end

