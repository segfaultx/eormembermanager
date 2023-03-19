import { Injectable } from '@angular/core'
import { HttpClient } from "@angular/common/http"
import { BehaviorSubject, Observable } from "rxjs"
import Member from "../model/Member"
import { environment } from "../environments/environment"

@Injectable({
  providedIn: 'root'
})
export class MemberService {

  private static BACKEND_BASE_URI = environment.BACKEND + "/api/member"
  private $membersSubject = new BehaviorSubject<Member[]>([])

  constructor(private httpClient: HttpClient) { }

  public init() {
    this.httpClient.get<Member[]>(MemberService.BACKEND_BASE_URI)
      .subscribe(response => this.$membersSubject.next(response))
  }

  public getAllMembers(): Observable<Member[]> {
    return this.$membersSubject
  }
}
