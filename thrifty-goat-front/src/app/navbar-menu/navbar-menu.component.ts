import { Component } from '@angular/core';
import { PopUpLogoutComponent } from '../pop-up-logout/pop-up-logout.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-navbar-menu',
  templateUrl: './navbar-menu.component.html',
  styleUrls: ['./navbar-menu.component.css']
})

export class NavbarMenuComponent {
  constructor(private modalService: NgbModal) { }

  openLogoutPopup() {
    const modalRef = this.modalService.open(LogoutPopupComponent);
    modalRef.componentInstance.name = 'World';
  }
}

export class LogoutPopupComponent {
  constructor(public modal: NgbActiveModal) { }
}

