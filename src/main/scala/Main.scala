import akka.actor.{ActorSystem, Props}

object Main extends App {

  val system = ActorSystem("bankExercise")
  val clerk = system.actorOf(Props(classOf[Clerk]))

  val savingsAccount = new SavingsAccount()
  val currentAccount = new CurrentAccount()

  clerk ! Deposit(savingsAccount, 100.0)
  clerk ! Withdraw(currentAccount, 100.0)

  savingsAccount.getBalance()
  currentAccount.getBalance()
}
