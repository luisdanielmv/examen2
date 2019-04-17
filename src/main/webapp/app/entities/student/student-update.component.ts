import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IStudent } from 'app/shared/model/student.model';
import { StudentService } from './student.service';
import { ITeam } from 'app/shared/model/team.model';
import { TeamService } from 'app/entities/team';
import { IStory } from 'app/shared/model/story.model';
import { StoryService } from 'app/entities/story';

@Component({
    selector: 'jhi-student-update',
    templateUrl: './student-update.component.html'
})
export class StudentUpdateComponent implements OnInit {
    student: IStudent;
    isSaving: boolean;

    teams: ITeam[];

    stories: IStory[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected studentService: StudentService,
        protected teamService: TeamService,
        protected storyService: StoryService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ student }) => {
            this.student = student;
        });
        this.teamService.query().subscribe(
            (res: HttpResponse<ITeam[]>) => {
                this.teams = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.storyService.query().subscribe(
            (res: HttpResponse<IStory[]>) => {
                this.stories = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.student.id !== undefined) {
            this.subscribeToSaveResponse(this.studentService.update(this.student));
        } else {
            this.subscribeToSaveResponse(this.studentService.create(this.student));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IStudent>>) {
        result.subscribe((res: HttpResponse<IStudent>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackTeamById(index: number, item: ITeam) {
        return item.id;
    }

    trackStoryById(index: number, item: IStory) {
        return item.id;
    }
}
