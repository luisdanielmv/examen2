import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Story } from 'app/shared/model/story.model';
import { StoryService } from './story.service';
import { StoryComponent } from './story.component';
import { StoryDetailComponent } from './story-detail.component';
import { StoryUpdateComponent } from './story-update.component';
import { StoryDeletePopupComponent } from './story-delete-dialog.component';
import { IStory } from 'app/shared/model/story.model';

@Injectable({ providedIn: 'root' })
export class StoryResolve implements Resolve<IStory> {
    constructor(private service: StoryService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Story> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Story>) => response.ok),
                map((story: HttpResponse<Story>) => story.body)
            );
        }
        return of(new Story());
    }
}

export const storyRoute: Routes = [
    {
        path: 'story',
        component: StoryComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'Stories'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'story/:id/view',
        component: StoryDetailComponent,
        resolve: {
            story: StoryResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Stories'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'story/new',
        component: StoryUpdateComponent,
        resolve: {
            story: StoryResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Stories'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'story/:id/edit',
        component: StoryUpdateComponent,
        resolve: {
            story: StoryResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Stories'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const storyPopupRoute: Routes = [
    {
        path: 'story/:id/delete',
        component: StoryDeletePopupComponent,
        resolve: {
            story: StoryResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Stories'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
