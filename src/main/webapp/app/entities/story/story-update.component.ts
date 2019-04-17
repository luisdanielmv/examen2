import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IStory } from 'app/shared/model/story.model';
import { StoryService } from './story.service';
import { ISprint } from 'app/shared/model/sprint.model';
import { SprintService } from 'app/entities/sprint';

@Component({
    selector: 'jhi-story-update',
    templateUrl: './story-update.component.html'
})
export class StoryUpdateComponent implements OnInit {
    story: IStory;
    isSaving: boolean;

    sprints: ISprint[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected storyService: StoryService,
        protected sprintService: SprintService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ story }) => {
            this.story = story;
        });
        this.sprintService.query().subscribe(
            (res: HttpResponse<ISprint[]>) => {
                this.sprints = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.story.id !== undefined) {
            this.subscribeToSaveResponse(this.storyService.update(this.story));
        } else {
            this.subscribeToSaveResponse(this.storyService.create(this.story));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IStory>>) {
        result.subscribe((res: HttpResponse<IStory>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackSprintById(index: number, item: ISprint) {
        return item.id;
    }
}
