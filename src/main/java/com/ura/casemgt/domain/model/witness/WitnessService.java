package com.ura.casemgt.domain.model.witness;

/**
 *
 * It is often said that domain services carry domain knowledge that doesn’t naturally fit entities and value objects.
 * There’s another reason, however, why you may want to introduce a domain service.
 * That reason is related to domain model isolation. More on that in just a minute.
 * So, what differs domain services from application services?
 *
 * Both these concepts assume stateless classes which can work on top of domain entities and value objects,
 * but that’s pretty much as far as their similarities go.
 * The main difference between them is that domain services hold domain logic whereas application services don’t.
 *
 * As we discussed in a previous post, domain logic is everything that is related to business decisions.
 * And application services orchestrate those decisions the same way they orchestrate decisions made by entities and value objects.
 *
 * One Service per Aggregate Root
 *
 */
public class WitnessService {
}
