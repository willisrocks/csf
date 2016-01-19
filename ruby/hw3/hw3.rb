class Hw3

  # greatest5() takes 5 integers
  # and returns the greatest
  def greatest5(a, b, c, d, e)
    max(a, max(b, max(c, max(d, e))))
  end

  # sum45() takes 5 integers and
  # returns the sum of the
  # greatest 4
  def sum45(a, b, c, d, e)
    min = min(a, min(b, min(c, min(d, e))))
    sum = a + b + c + d + e
    sum - min
  end

  # anyDivide3() takes 3 integers
  # and returns a boolean indicating
  # if any of the 3 parameters
  # divide evenly into another
  def anyDivide3(a, b, c)
    if (a % b or a % c) == 0
      true
    elsif (b % a or b % c) == 0
      true
    elsif (c % a or c % b) == 0
      true
    else
      false
    end

  end

  # sumEven4() takes 4 integers and
  # returns the sume of the parameters
  # that are even
  def sumEven4(a, b, c, d)
    sum = 0
    if a % 2 == 0
      sum += a
    end
    if b % 2 == 0
      sum += b
    end
    if c % 2 == 0
      sum += c
    end
    if d % 2 == 0
      sum += d
    end
    sum
  end

  # sumEvenProdOdd4() takes 4 integers
  # and returns the sum of the numbers
  # that are even plus the product of
  # the numbers that are odd
  def sumEvenProdOdd4(a, b, c, d)
    sum = 0
    prod = 1
    a % 2 == 0 ? sum += a : prod *= a
    b % 2 == 0 ? sum += b : prod *= b
    c % 2 == 0 ? sum += c : prod *= c
    d % 2 == 0 ? sum += d : prod *= d
    sum + prod
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
