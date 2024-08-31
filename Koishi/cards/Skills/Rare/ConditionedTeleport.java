/*    */ package Koishi.cards.Skills.Rare;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.FleetingField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.rooms.AbstractRoom;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class ConditionedTeleport
/*    */   extends AbstractDefaultCard {
/* 21 */   public static final String ID = KoishiMod.makeID(ConditionedTeleport.class.getSimpleName());
/* 22 */   public static final String IMG = KoishiMod.makeCardPath("ConditionedTeleport.png");
/*    */   
/* 24 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 25 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
/* 26 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
/* 27 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   public ConditionedTeleport() {
/* 32 */     super(ID, IMG, 0, TYPE, COLOR, RARITY, TARGET);
/* 33 */     this.isInnate = true;
/* 34 */     FleetingField.fleeting.set(this, Boolean.valueOf(true));
/* 35 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 41 */     return 18.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 47 */     boolean hasBoss = false;
/* 48 */     Iterator<AbstractMonster> iterator = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 49 */     while (iterator.hasNext()) {
/* 50 */       AbstractMonster mo = iterator.next();
/* 51 */       if (mo.type == AbstractMonster.EnemyType.BOSS) {
/* 52 */         hasBoss = true;
/*    */       }
/*    */     } 
/* 55 */     if ((AbstractDungeon.getCurrRoom()).phase == AbstractRoom.RoomPhase.COMBAT && !hasBoss) {
/* 56 */       (AbstractDungeon.getCurrRoom()).smoked = true;
/* 57 */       AbstractDungeon.player.hideHealthBar();
/* 58 */       AbstractDungeon.player.isEscaping = true;
/* 59 */       AbstractDungeon.player.flipHorizontal = !AbstractDungeon.player.flipHorizontal;
/* 60 */       AbstractDungeon.overlayMenu.endTurnButton.disable();
/* 61 */       AbstractDungeon.player.escapeTimer = 2.5F;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerWhenDrawn() {
/* 67 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DrawCardAction((AbstractCreature)AbstractDungeon.player, 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 72 */     if (!this.upgraded) {
/* 73 */       upgradeName();
/* 74 */       FleetingField.fleeting.set(this, Boolean.valueOf(false));
/* 75 */       this.rawDescription = (CardCrawlGame.languagePack.getCardStrings(this.cardID)).UPGRADE_DESCRIPTION;
/* 76 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Skills/Rare/ConditionedTeleport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */