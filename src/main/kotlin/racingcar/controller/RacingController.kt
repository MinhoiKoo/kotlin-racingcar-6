package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarName
import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun startRace() {
        initializeRace()
    }

    private fun inputCarName(): List<CarName> {
        outputView.printInputName()
        return inputView.inputCarName()
    }

    fun inputRound(): Int {
        outputView.printInputRound()
        return inputView.inputRound()
    }

    private fun initializeRace() {
        val cars = mutableListOf<Car>()
        inputCarName().forEach {
            // 원시값 포장을 풀어서 Model에 전달
            cars.add(Car(it.name))
        }
        runRace(Cars(cars))
    }

    private fun runRace(cars: Cars) {
        repeat(inputRound()) {
            cars.raceCars()
            outputView.printRacing(cars)
        }
        val winner = cars.getWinners()
    }
}