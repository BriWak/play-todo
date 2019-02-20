package models

import java.time.LocalDate

sealed abstract case class NonEmptyString(value: String)

object NonEmptyString {

  def apply(value: String): Option[NonEmptyString] =
    if (value.nonEmpty) Some(new NonEmptyString(value) {})
    else None
}

case class Todo(name: NonEmptyString, description: String, state: TodoState)



sealed trait TodoState

case object Open extends TodoState
case class Completed(completeOnDate: LocalDate) extends TodoState
case class Closed(closedOn: LocalDate) extends TodoState
