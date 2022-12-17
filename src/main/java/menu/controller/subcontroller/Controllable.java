package menu.controller.subcontroller;

import menu.domain.status.ApplicationStatus;

@FunctionalInterface
public interface Controllable {
    ApplicationStatus process();
}