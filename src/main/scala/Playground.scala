import akka.actor._

case class Withdraw(id: String, amount: Double)
case class Deposit(id: String, amount: Double)

object Bank {

  trait Account[T] {
    protected balance : Double = 0.0

    def deposit(amount: Double): Account[T] = {

    }
    def withdraw(amount: Double): Account[T]
  }
}
abstract class Account(id: String, balance: Double) {
  def deposit(amount: Double): Account =
  def withdraw(amount: Double): Account
}
class SavingsAccount(id: String, balance: Double = 0.0) {

  def deposit(amount: Double): SavingsAccount = {
    new SavingsAccount(balance + amount)
  }

  def withdraw (amount: Double): Either[SavingsAccount, UnsupportedOperationException] = {
    if (balance - amount < 0.0) {
      Right(throw new UnsupportedOperationException("Unable to withdraw more money than you have."))
    }
    Left(new SavingsAccount(balance - amount))
  }

}

class CurrentAccount(id: String, balance: Double = 0.0) {

  def withdraw (amount: Double): CurrentAccount = {
    new CurrentAccount(balance - amount)
  }

  def deposit(amount : Double): CurrentAccount = {
    new CurrentAccount(balance + amount)
  }
}

class Clerk extends Actor {

  override def receive = {
    case Withdraw(amount) => withdraw(amount)
    case Deposit(amount)  => deposit(amount)
  }
}
