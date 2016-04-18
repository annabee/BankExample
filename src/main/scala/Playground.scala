class Account(val name: String, val balance: Double) {

  def deposit(amount : Double): Account = {
    new Account(name, balance + amount)
  }
}

class SavingsAccount(override val name: String, override val balance: Double) extends  Account(name: String, balance: Double) {

  def withdraw (amount: Double): Either[SavingsAccount, UnsupportedOperationException] = {
    if (balance - amount < 0.0) {
      Right(throw new UnsupportedOperationException("Unable to withdraw more money than you have."))
    }
    Left(new SavingsAccount(name, balance - amount))
  }
}

class CurrentAccount(override val name: String, override val balance: Double) extends Account(name: String, balance: Double) {

  def withdraw (amount: Double): CurrentAccount = {
    new CurrentAccount(name, balance - amount)
  }
}
