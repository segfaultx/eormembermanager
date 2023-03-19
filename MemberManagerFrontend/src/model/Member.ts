interface Member {
  id: number,
  name: string,
  server: string,
  avatarUri: string,
  jobInfos: JobInfo[],
  joinedDate: Date,
  promotionDate: Date
}

interface JobInfo {
  name: string,
  level: number,
  classType: string
}

export default Member
