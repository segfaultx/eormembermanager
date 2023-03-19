import { Component, OnInit } from '@angular/core'
import { MemberService } from "../services/member.service"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'MemberManagerFrontend';

  members = this.memberService.getAllMembers()

  constructor(private memberService: MemberService) {
  }

  ngOnInit(): void {
    this.memberService.init()
  }
}
