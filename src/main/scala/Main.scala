import akka.actor.{ActorSystem, Props}

object Main extends App {

  val system = ActorSystem("bankExercise")
  val clerk = system.actorOf(Props(classOf[Clerk]))

  val savingsAccount = new SavingsAccount("111")
  val currentAccount = new CurrentAccount("222")

  clerk ! Deposit(savingsAccount, 100.0)
  clerk ! Withdraw(currentAccount, 100.0)

  savingsAccount.getBalance()
  currentAccount.getBalance()
}
